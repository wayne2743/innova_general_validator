package com.wayne.general.validate.model;

public class ValidatorResponse {
    int httpStatus;
    String result;
    int errorCode;
    String errorMsg;
    
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + httpStatus;
        result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
        result = prime * result + errorCode;
        result = prime * result + ((errorMsg == null) ? 0 : errorMsg.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ValidatorResponse other = (ValidatorResponse) obj;
        if (httpStatus != other.httpStatus)
            return false;
        if (result == null) {
            if (other.result != null)
                return false;
        } else if (!result.equals(other.result))
            return false;
        if (errorCode != other.errorCode)
            return false;
        if (errorMsg == null) {
            if (other.errorMsg != null)
                return false;
        } else if (!errorMsg.equals(other.errorMsg))
            return false;
        return true;
    }

    public ValidatorResponse(int httpStatus, String result, int errorCode, String errorMsg) {
        this.httpStatus = httpStatus;
        this.result = result;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
