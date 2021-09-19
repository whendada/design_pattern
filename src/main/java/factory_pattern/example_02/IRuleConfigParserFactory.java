package factory_pattern.example_02;

import factory_pattern.IRuleConfigParser;

public interface IRuleConfigParserFactory {
    IRuleConfigParser creatParser();
}
