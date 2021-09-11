package factory_pattern.impl;

import factory_pattern.IRuleConfigParser;
import factory_pattern.RuleConfig;

public class JsonRuleConfigParser implements IRuleConfigParser {

    @Override
    public RuleConfig parse(String configText) {
        return new RuleConfig();
    }
}
