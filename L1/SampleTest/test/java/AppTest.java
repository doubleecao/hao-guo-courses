import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void hello() {
        App h = new App();
        String str = "World";

        assertEquals("HelloWorld", h.Hello(str));
    }
}