package co.istad.chhaya.fswd_sbapp.exception;

public record FiledErrorResponse(
    String field,
    String reason
) {
}
