package factory_pattern;

public interface IRuleConfigParser {

    // //从ruleConfigFilePath文件中读取配置文本到configText中
    RuleConfig parse(String configText);
}
