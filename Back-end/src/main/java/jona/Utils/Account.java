package jona.Utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Account {
    @JsonProperty("_id")
    IdObject id;
    @JsonProperty("username")
    String username;
    @JsonProperty("id")
    int userCode;
    @JsonProperty("platform")
    String platform;
    @JsonProperty("mode")
    String mode;

    static class IdObject {
        @JsonProperty("$oid")
        String oid;

        public String getOid() {
            return oid;
        }

        public void setOid(String oid) {
            this.oid = oid;
        }
    }

    public IdObject getId() {
        return id;
    }

    public void setId(IdObject id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
