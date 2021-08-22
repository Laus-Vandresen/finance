package io.app.finance.enuns;

import io.app.finance.converter.AbstractEnumConverter;
import io.app.finance.converter.PersistableEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountTypeEnum implements PersistableEnum<String> {

    CHECKING_ACCOUNT("C"),
    SAVING_ACCOUNT("S");

    private final String value;

    public static class Converter extends AbstractEnumConverter<AccountTypeEnum, String> {
        public Converter() {
            super(AccountTypeEnum.class);
        }
    }
}
