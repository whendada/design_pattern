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
        /**
         * 以前的写法，不用函数，直接通过判断
         *
         *         switch (ruleConfigFileExtension) {
         *             case "json":
         *                 parser = new JsonRuleConfigParser();
         *                 break;
         *             case "xml":
         *                 parser = new XmlRuleConfigParser();
         *                 break;
         *             case "yml":
         *                 parser = new YamlRuleConfigParser();
         *                 break;
         *             case "properties":
         *                 parser = new PropertiesRuleConfigParser();
         *                 break;
         *         }
         */
        parser = createParser(ruleConfigFileExtension);
        // 从 ruleConfigFilePath 文件中读取配置文本到 configText 中
        String configText = "";
        RuleConfig ruleConfig = new RuleConfig();
        if (Objects.nonNull(parser)) {
            ruleConfig = parser.parse(configText);
        }
        return ruleConfig;
    }

    private String getFileExtension(String ruleConfigFilePath) {
        // 读取 ruleConfigFilePath 文件的文件扩展名
        return ruleConfigFilePath + "and so on";
    }

    /**
     * 1、优化：将功能独立的函数封装出来
     */
    private IRuleConfigParser createParser(String configFormat) {
        IRuleConfigParser parser = null;
        switch (configFormat) {
            case "json":
                parser = new JsonRuleConfigParser();
                break;
            case "xml":
                parser = new XmlRuleConfigParser();
                break;
            case "yml":
                parser = new YamlRuleConfigParser();
                break;
            case "properties":
                parser = new PropertiesRuleConfigParser();
                break;
        }
        return parser;
    }

    /**
     * 2、将 createParser() 函数独立出来封装成类，这个类就是简单工模式厂类
     *
     * 2.1、简单工厂模式第一种实现方式：
     * public class RuleConfigParserFactory {
     *         public static IRuleConfigParser createParser(String configFormat) {
     *             IRuleConfigParser parser = null;
     *             if ("json".equalsIgnoreCase(configFormat)) {
     *                 parser = new JsonRuleConfigParser();
     *             } else if ("xml".equalsIgnoreCase(configFormat)) {
     *                 parser = new XmlRuleConfigParser();
     *             } else if ("yaml".equalsIgnoreCase(configFormat)) {
     *                 parser = new YamlRuleConfigParser();
     *             } else if ("properties".equalsIgnoreCase(configFormat)) {
     *                 parser = new PropertiesRuleConfigParser();
     *             }
     *             return parser;
     *         }
     *     }
     *
     * 2.2、简单工程模式第二种实现方式(Map)
     * public class RuleConfigParserFactory {
     *         private static final Map<String, IRuleConfigParser> cachedParsers = new HashMap<>();
     *
     *         static {
     *             cachedParsers.put("json", new JsonRuleConfigParser());
     *             cachedParsers.put("xml", new XmlRuleConfigParser());
     *             cachedParsers.put("yaml", new YamlRuleConfigParser());
     *             cachedParsers.put("properties", new PropertiesRuleConfigParser());
     *         }
     *
     *         public static IRuleConfigParser createParser(String configFormat) {
     *             if (configFormat == null || configFormat.isEmpty()) {
     *                 return null;//返回null还是IllegalArgumentException全凭你自己说了算
     *             }
     *             IRuleConfigParser parser = cachedParsers.get(configFormat.toLowerCase());
     *             return parser;
     *         }
     *     }
     *
     *
     * 3、工厂方法
     * 利用多态去掉 if，参考 IRuleConfigParserFactory
     */

}
