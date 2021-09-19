package factory_pattern.example_02;

import factory_pattern.IRuleConfigParser;
import factory_pattern.impl.JsonRuleConfigParser;

public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser creatParser() {
        return new JsonRuleConfigParser();
    }
}
