package io.app.finance.enuns;

import io.app.finance.converter.AbstractEnumConverter;
import io.app.finance.converter.PersistableEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TransactionCategoryEnum implements PersistableEnum<String> {

    FIXED_EXPENSE("F"),
    GENERAL_COSTS("G"),
    WAGE("W");

    private String value;

    public static class Converter extends AbstractEnumConverter<TransactionCategoryEnum, String> {
        public Converter() {
            super(TransactionCategoryEnum.class);
        }
    }
}
