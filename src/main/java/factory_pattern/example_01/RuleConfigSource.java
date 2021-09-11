package factory_pattern.example_01;

import factory_pattern.IRuleConfigParser;
import factory_pattern.RuleConfig;
import factory_pattern.impl.JsonRuleConfigParser;
import factory_pattern.impl.PropertiesRuleConfigParser;
import factory_pattern.impl.XmlRuleConfigParser;
import factory_pattern.impl.YamlRuleConfigParser;

import java.util.Objects;

public class RuleConfigSource {

    public RuleConfig load(String ruleConfigFilePath) {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = null;
        if (Objects.equals(ruleConfigFileExtension, "json")) {
            parser = new JsonRuleConfigParser();
        } else if (Objects.equals(ruleConfigFileExtension, "xml")) {
            parser = new XmlRuleConfigParser();
        } else if (Objects.equals(ruleConfigFileExtension, "yml")) {
            parser = new YamlRuleConfigParser();
        } else if (Objects.equals(ruleConfigFileExtension, "properties")) {
            parser = new PropertiesRuleConfigParser();
        }

        // 从 ruleConfigFilePath 文件中读取配置文本到 configText 中
        String configText = "";
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String ruleConfigFilePath) {
        // 读取 ruleConfigFilePath 文件的文件扩展名
        String extensionName = "";
        return extensionName;
    }

    /**
     * 1、优化：将功能独立的函数封装出来
     */
}
