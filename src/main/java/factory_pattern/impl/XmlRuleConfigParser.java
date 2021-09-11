package factory_pattern.impl;

import factory_pattern.IRuleConfigParser;
import factory_pattern.RuleConfig;

public class XmlRuleConfigParser implements IRuleConfigParser {

    @Override
    public RuleConfig parse(String configText) {
        return new RuleConfig();
    }
}
