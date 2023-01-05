package com.naura.test.lower;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
public class LowerConnection {
    private String host;
    private String port;

    @NotNull
    public String remoteAppEntrance() {
        return "RemoteAppEntrance:default -p " + port + " -h " + host;
    }

    @NotNull
    public String hostPort() {
        return "-p " + port + " -h " + host;
    }
}