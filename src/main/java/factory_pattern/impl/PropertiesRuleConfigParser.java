package factory_pattern.impl;

import factory_pattern.IRuleConfigParser;
import factory_pattern.RuleConfig;

public class PropertiesRuleConfigParser implements IRuleConfigParser {

    @Override
    public RuleConfig parse(String configText) {
        return new RuleConfig();
    }
}
