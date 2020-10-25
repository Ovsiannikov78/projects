import de.telran.service.ConfigService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ConfigServiceTest {

    ConfigService service;

    @Before
    public void setUp() throws Exception {
        service = new ConfigService();
    }

    @Test
    public void testGetPathSeparator() {
        String pathSeparator = service.getPathSeparator();
        assertTrue(";".equals(pathSeparator));
    }

    @Test
    public void testGetPathToSavedImages() {
        String pathSeparator = service.getPathToSavedImages();
        assertNotNull(pathSeparator);
    }
}