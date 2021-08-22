package io.app.finance.enuns;

import io.app.finance.converter.AbstractEnumConverter;
import io.app.finance.converter.PersistableEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TransactionTypeEnum implements PersistableEnum<String> {

    ENTRY("E"),
    OUT("O");

    private String value;

    public static class Converter extends AbstractEnumConverter<TransactionTypeEnum, String> {
        public Converter() {
            super(TransactionTypeEnum.class);
        }
    }
}
