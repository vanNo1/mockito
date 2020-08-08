package van.unittest.test.mockAction;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

/**
 * answer用于mock一个更为复杂的行为
 */
@RunWith(MockitoJUnitRunner.class)
public class Answer {
    private List list;
    @Before
    public void setUp(){
        this.list= Mockito.mock(List.class);
    }
    //mock一个更复杂的行为
    @Test
    public void answer(){
        when(list.get(anyInt())).thenAnswer(invocationOnMock -> {
            Integer param=invocationOnMock.getArgument(0,Integer.class);
            return String.valueOf(param*10);
        });
        System.out.println(list.get(1));
    }
}
