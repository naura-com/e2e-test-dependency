package com.naura.test.ui.page;

import java.util.function.Supplier;

public class ParentPage {
    protected Object current;

    public ParentPage(Object current) {
        this.current = current;
    }

    public ParentPage() {
        current = null;
    }

    @SuppressWarnings("unchecked")
    protected <T> T switchTo(Class<T> pageType, Runnable open, Supplier<T> constructor) {
        if (pageType.isInstance(current))
            return (T) current;
        open.run();
        return (T) (current = constructor.get());
    }

    public void reset() {
        current = null;
    }
}
