package com.naura.test.ui.driver;

import com.github.kilianB.hash.Hash;
import com.github.kilianB.hashAlgorithms.PerceptiveHash;
import com.github.leeonky.util.NumberParser;
import com.naura.test.ui.page.HashValue;
import io.appium.java_client.MobileElement;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import lombok.SneakyThrows;
import org.apache.logging.log4j.util.TriConsumer;
import org.openqa.selenium.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toMap;
import static org.awaitility.Awaitility.await;
import static org.openqa.selenium.By.xpath;

public abstract class Window {
    protected abstract WindowsElement findElementByName(String name);

    protected abstract WindowsElement findElement(By by);

    protected abstract WindowsElement findElementByTag(String tag);

    protected abstract List<WindowsElement> findElementsByTag(String tag);

    protected abstract WindowsElement findElementById(String id);

    private WindowsElement waitElement(Callable<WindowsElement> elementCallable) {
        return await().ignoreExceptions().until(elementCallable, Objects::nonNull);
    }

    public WindowOperation elementById(String id) {
        return new WindowOperation(waitElement(() -> findElementById(id)));
    }

    public WindowOperation elementByName(String name) {
        return new WindowOperation(waitElement(() -> findElementByName(name)));
    }

    public WindowOperation elementByTag(String tag) {
        return new WindowOperation(waitElement(() -> findElementByTag(tag)));
    }

    public List<WindowOperation> elementsByTag(String tag) {
        return findElementsByTag(tag).stream().map(WindowOperation::new).collect(Collectors.toList());
    }


    public WindowOperation element(String xpath) {
        return new WindowOperation(waitElement(() -> findElement(xpath(xpath))));
    }

    public static class WindowOperation extends Window {
        private final WindowsElement element;
        private final NumberParser numberParser = new NumberParser();

        @Override
        protected WindowsElement findElementByName(String name) {
            return (WindowsElement) element.findElementByName(name);
        }

        @Override
        protected WindowsElement findElement(By by) {
            return (WindowsElement) element.findElement(by);
        }

        @Override
        protected WindowsElement findElementByTag(String tag) {
            return (WindowsElement) element.findElementByTagName(tag);
        }

        @Override
        protected List<WindowsElement> findElementsByTag(String tag) {
            return element.findElementsByTagName(tag).stream().map(WindowsElement.class::cast).collect(Collectors.toList());
        }

        @Override
        protected WindowsElement findElementById(String id) {
            return (WindowsElement) element.findElementByAccessibilityId(id);
        }

        public WindowOperation(WindowsElement element) {
            this.element = element;
        }

        public static final TriConsumer<WindowOperation, WindowOperation, Object> FILL_BY_COMBO_BOX = (table, cell, value) -> {
            if (value != null) {
                cell.click().click(); //should click twice!!!
                table.elementByTag("ComboBox").elementByName(value.toString()).click();
            }
        };

        public static final TriConsumer<WindowOperation, WindowOperation, Object> FILL_BY_TEXT_BOX = (table, cell, value) -> {
            cell.click().click();
            cell.sendKeys((String) value);
        };

        public static final TriConsumer<WindowOperation, WindowOperation, Object> CLICK_ONE_BY_TEXT_BOX = (table, cell, value) -> {
            cell.click();
            cell.sendKeys((String) value);
        };

        public void fillTable(List<Map<String, String>> data,
                              Function<String, TriConsumer<WindowOperation, WindowOperation, Object>> setter) {
            for (int row = 0; row < data.size(); row++) {
                List<Map<Object, WindowOperation>> tableControl = asTable();
                Map<Object, WindowOperation> rowControl = tableControl.get(row);
                data.get(row).forEach((key, value) -> setter.apply(key).accept(this, rowControl.get(key), value));
            }
        }

        //TODO:可用editTableCol替代
        public void editTableByParam(List<Map<String, String>> data,
                                     Function<String, TriConsumer<WindowOperation, WindowOperation, Object>> setter) {
            List<Map<Object, WindowOperation>> tableControl = asTable();
            for (int row = 0; row < data.size(); row++) {
                String parameter = data.get(row).get("parameter");
                String value = data.get(row).get("value");
                for (int dgvRow = 0; dgvRow < tableControl.size(); dgvRow++) {
                    Map<Object, WindowOperation> rowControl = tableControl.get(dgvRow);
                    if (rowControl.get("Parameter").getText().equals(parameter))
                        setter.apply("1").accept(this, rowControl.get(1), value);
                }
            }
        }

        public void editTableCol(List<Map<String, String>> data,
                                 Function<String, TriConsumer<WindowOperation, WindowOperation, Object>> setter) {
            List<Map<Object, WindowOperation>> tableControl = asTable();
            for (int row = 0; row < data.size(); row++) {
                List<String> list = new ArrayList<>(data.get(row).keySet());
                for (int dgvRow = 0; dgvRow < tableControl.size(); dgvRow++) {
                    Map<Object, WindowOperation> rowControl = tableControl.get(dgvRow);
                    if (rowControl.get(list.get(0)).getText().equals(data.get(row).get(list.get(0)))) {
                        for (int i = 1; i < list.size(); i++) {
                            if (list.get(i).contains("[") || data.get(row).get(list.get(i)).equals("*"))
                                continue;
                            if (list.get(i).matches("^[0-9]*[1-9][0-9]*$"))
                                setter.apply("1").accept(this, rowControl.get(Integer.parseInt(list.get(i))), data.get(row).get(list.get(i)));
                            else
                                setter.apply("1").accept(this, rowControl.get(list.get(i)), data.get(row).get(list.get(i)));
                        }
                    }
                }
            }
        }

        public void selectColumn(String colName) {
            List<Map<Object, WindowOperation>> tableControl = asTable();
            if (colName.matches("^[0-9]*[1-9][0-9]*$"))
                tableControl.get(0).get(Integer.parseInt(colName)).click();
            else tableControl.get(0).get(colName).click();
        }

        public void selectColumnHeader(String colName) {
            List<Map<Object, WindowOperation>> tableControl = asTable();
            if (colName.matches("^[0-9]*[1-9][0-9]*$"))
                tableControl.get(0).get(Integer.parseInt(colName)).selectColumn(colName);
            else tableControl.get(0).get(colName).selectColumn(colName);
        }

        public WindowOperation click() {
            element.click();
            return this;
        }

        public WindowOperation sendKeys(String text) {
            element.sendKeys(text);
            return this;
        }

        public WindowOperation Keyboard(Keys keys) {
            element.sendKeys(keys);
            return this;
        }

        public WindowOperation selectByName(String... texts) {
            WindowOperation window = click();
            for (String text : texts)
                window = window.elementByName(text).click();
            return this;
        }

        public Object getValue() {
            return parseValue(getText());
        }

        private Object parseValue(String text) {
            Number number = numberParser.parse(text);
            return number == null ? text : number;
        }

        public String getText() {
            return element.getText();
        }

        public String getId() {
            return element.getId();
        }

        public String getAttribute(String name) {
            return element.getAttribute(name);
        }

        public List<Map<Object, WindowOperation>> asTable() {
            if (element.getTagName().equals("ControlType.Table")) {
                Set<Object> headers = element.findElementByTagName("Custom")
                        .findElementsByTagName("Header").stream()
                        .map(mobileElement -> parseValue(mobileElement.getText()))
                        .collect(toCollection(LinkedHashSet::new));
                LinkedList<MobileElement> cells = new LinkedList<>(element.findElementsByXPath("//Custom[position()>1]/*"));
                return new ArrayList<>() {{
                    while (!cells.isEmpty())
                        add(headers.stream().collect(Collectors.toMap(Function.identity(),
                                k -> new WindowOperation((WindowsElement) cells.pop()))));
                }};
            }
            return elementByTag("Table").asTable();
        }

        public MobileElement getXpathElement(String xpath) {
            return element.findElementByXPath(xpath);
        }

        public List<MobileElement> getXpathElements(String xpath) {
            return element.findElementsByXPath(xpath);
        }

        public Set<Object> getTableHeader() {
            Set<Object> headers = element.findElementByTagName("Custom")
                    .findElementsByTagName("Header").stream()
                    .map(mobileElement -> parseValue(mobileElement.getText()))
                    .collect(toCollection(LinkedHashSet::new));
            return headers;
        }

        public Set<Object> getTablePage() {
            Set<Object> page = element.findElementByTagName("Tab")
                    .findElementsByTagName("TabItem").stream()
                    .map(mobileElement -> parseValue(mobileElement.getText()))
                    .collect(toCollection(LinkedHashSet::new));
            return page;
        }

        public List<List<Object>> getAllListValue() {
            List<List<Object>> list = new ArrayList<>();
            List<MobileElement> mobileElementList = element.findElementsByTagName("ListItem");
            for (int i = 0; i < mobileElementList.size(); i++) {
                List<Object> listItem = new ArrayList<>();
                listItem.add(mobileElementList.get(i).findElementsByTagName("Text").stream()
                        .map(mobileElement -> parseValue(mobileElement.getText()))
                        .collect(Collectors.toList()));
                list.add(listItem);
            }
            return list;
        }

        public List<Map<Object, Object>> getTableValue() {
            return asTable().stream().map(row -> row.entrySet().stream().collect(toMap(Map.Entry::getKey,
                            e -> e.getValue().getValue(), (m1, m2) -> m2, LinkedHashMap::new)))
                    .collect(Collectors.toList());
        }

        public WindowOperation select(int index) {
            click();
            List<MobileElement> items = element.findElementsByTagName("ListItem");
            MobileElement mobileElement = index > 0 ? items.get(index) : items.get(items.size() + index);
            mobileElement.click();
            return this;
        }

        public List<Object> getListValue() {
            return element.findElementsByTagName("ListItem").stream()
                    .map(item -> parseValue(item.getText())).collect(Collectors.toList());
        }

        //TODO:有点问题
        public List<Object> getPanelValue() {
            return element.findElementsByTagName("Pane").stream()
                    .map(item -> parseValue(item.getText())).collect(Collectors.toList());
        }

        public WindowOperation clear() {
            element.clear();
            return this;
        }

        @SneakyThrows
        public byte[] screenShot() {
            BufferedImage subImage = screenShotBufferedImage();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(subImage, "PNG", outputStream);
            return outputStream.toByteArray();
        }

        @SneakyThrows
        public BufferedImage screenShotBufferedImage() {
            BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream
                    (((WindowsDriver<WindowsElement>) element.getWrappedDriver()).getScreenshotAs(OutputType.BYTES)));
            Point location = element.getLocation();
            Dimension size = element.getSize();
            return bufferedImage.getSubimage(location.x, location.y, size.width, size.height);
        }

        public String getImageValue(Map<Hash, String> uiValueMap) {
            BufferedImage image = screenShotBufferedImage();
            Hash hash = new PerceptiveHash(128).hash(image);
            HashValue hashValue = uiValueMap.entrySet().stream()
                    .map(e -> new HashValue(e.getValue(), e.getKey().normalizedHammingDistance(hash)))
                    .min(Comparator.comparing(HashValue::getScore))
                    .orElseThrow(() -> new IllegalArgumentException("Input image hash value map is empty"));
            if (hashValue.getScore() > 0.01)
                throw new IllegalStateException("All candidate hash value " + uiValueMap + " are not similar");
            return hashValue.getValue();
        }

        public Object getHash() {
            BufferedImage image = screenShotBufferedImage();
            Hash hash = new PerceptiveHash(128).hash(image);
            return hash.getHashValue();
        }

        public WebElement getElement() {
            return element;
        }

        public WindowOperation selectCell(int rowIndex, String colName) {
            List<Map<Object, WindowOperation>> tableControl = asTable();
            if (colName.matches("^[0-9]*[1-9][0-9]*$")) {
                tableControl.get(rowIndex).get(Integer.parseInt(colName)).click();
                return tableControl.get(rowIndex).get(Integer.parseInt(colName));
            } else {
                tableControl.get(rowIndex).get(colName).click();
                return tableControl.get(rowIndex).get(colName);
            }
        }

        public void selectCellByColumnName(String colName, String cellName) {
            List<Map<Object, WindowOperation>> tableControl = asTable();
            for (Map<Object, WindowOperation> row : tableControl) {
                if (row.get(colName).getText().equals(cellName)) {
                    row.get(colName).click();
                    break;
                }
            }
        }

        public boolean isSelect() {
            return element.isSelected();
        }

        public String getCellValue(int rowIndex, String colName) {
            List<Map<Object, WindowOperation>> tableControl = asTable();
            if (colName.matches("^[0-9]*[1-9][0-9]*$")) {
                return tableControl.get(rowIndex).get(Integer.parseInt(colName)).getText();
            } else {
                return tableControl.get(rowIndex).get(colName).getText();
            }
        }

        public WindowOperation select(boolean operation) {
            if ((operation && !element.isSelected()) || (!operation && element.isSelected())) {
                element.click();
            }
            return this;
        }

        public boolean isEnabled() {
            return element.isEnabled();
        }

        public List<Object> getElementListValue(String xpath) {
            return element.findElementsByXPath(xpath).stream()
                    .map(item -> parseValue(item.getText())).collect(Collectors.toList());
        }

        public void selectCell(String col1Name, String col1Value, String col2Name) {
            List<Map<Object, WindowOperation>> tableControl = asTable();
            for (Map<Object, WindowOperation> row : tableControl) {
                if (row.get(col1Name).getText().equals(col1Value)) {
                    row.get(col2Name).click();
                    break;
                }
            }
        }
    }
}
