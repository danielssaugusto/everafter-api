package org.example.enums;

public enum RSVPStatus {
    ATTENDING(1, "Guest confirmed"),
    NOT_ATTENDING(2, "Guest not confirmed"),
    PENDING(3, "Awaiting guest response"),
    DECLINED(4, "Guest not accept the invite");

    private final int code;
    private final String description;

    private RSVPStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public RSVPStatus ofCode(int code) {
        for (RSVPStatus status : RSVPStatus.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status code: " + code);
    }

    // Explicando com minhas palavras: declarei um método para identificar o código trazido pelo banco de dados
    // Vou pegar os enumerates, todos eles, e para cada valor dos status (1, 2, 3...), se algum código corresponder com o codigo do parametro do método, ele vai retornar o status. Caso isso não ocorra ele vai lançar um exceção com a mensagem de erro.
}
