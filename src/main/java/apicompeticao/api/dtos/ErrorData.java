package apicompeticao.api.dtos;

public record ErrorData(String field, String message) {
    public ErrorData(String field, String message) {
        this.message = message;
        this.field = field;
    }

}
