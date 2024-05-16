import org.junit.jupiter.api.Test;
import org.spring.framework.beans.factory.BeanFactory;

import static org.assertj.core.api.Assertions.assertThat;


public class testSimpleBeanFactory {

    @Test
    public void testSimpleBeanFactory(){
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.registerBean("testCreateBean",new TestCreateBean());
        TestCreateBean testCreateBean = (TestCreateBean)beanFactory.getBean("testCreateBean");
        //testCreateBean.testCreateBean();
        assertThat(testCreateBean).isNotNull();
        assertThat(testCreateBean.testCreateBean()).isEqualTo("test bean");
    }


    class TestCreateBean{

        public String testCreateBean(){
            System.out.println("this is test bean");
            return "test bean";
        }
    }
}
