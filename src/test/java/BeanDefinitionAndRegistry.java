import org.junit.Test;
import org.spring.framework.beans.factory.config.BeanDefinition;
import org.spring.framework.beans.factory.support.DefultListableBeanFactroy;

public class BeanDefinitionAndRegistry {


    @Test
    public void testBeanDefinitionAndRegistry() {
        DefultListableBeanFactroy beanFactroy = new DefultListableBeanFactroy();
        BeanDefinition beanDefinition = new BeanDefinition(TestSimpleBeanFactory.class);
        beanFactroy.registerBeanDefinition("testSimpleBeanFactory", beanDefinition);
        TestSimpleBeanFactory testSimpleBeanFactory = (TestSimpleBeanFactory) beanFactroy.getBean("testSimpleBeanFactory");
        testSimpleBeanFactory.testCreateBean();
    }

}
