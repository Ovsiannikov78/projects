import de.telran.entity.ImageDescriptor;
import de.telran.service.ConfigService;
import de.telran.service.CsvFileService;
import de.telran.service.ImageDescriptorService;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class ImageDescriptorServiceTest {

    //mock creation
    CsvFileService csvFileService = mock(CsvFileService.class);
    ConfigService configService = mock(ConfigService.class);

    @Test
    public void testGetEmptyImageDescriptors() {
        //configure mocks
        when(csvFileService.loadStringsFromFile("testfile.txt")).thenReturn(Collections.emptyList());

        //execute testing code

        ImageDescriptorService service = new ImageDescriptorService(csvFileService, configService);
        List<ImageDescriptor> imageDescriptors = service.getImageDescriptors("testfile.txt");

        //assert results
        assertTrue(imageDescriptors.isEmpty());

        verify(csvFileService, times(1)).loadStringsFromFile("testfile.txt");

    }

    @Test
    public void testGetImageDescriptors() {
        //configure mocks
        when(csvFileService.loadStringsFromFile("testfile.txt")).thenReturn(createTestString());
        when(configService.getPathSeparator()).thenReturn(";");
        when(configService.getPathToSavedImages()).thenReturn("/Users/sergiiovsiannikov/Desktop/ImageSaveTest/");

        //execute testing code

        ImageDescriptorService service = new ImageDescriptorService(csvFileService, configService);
        List<ImageDescriptor> imageDescriptors = service.getImageDescriptors("testfile.txt");

        //assert results
        System.out.println(imageDescriptors);
        assertEquals(2, imageDescriptors.size());
        assertEquals("abc", imageDescriptors.get(0).getImageUrlName());
        assertEquals("PREVIEW", imageDescriptors.get(0).getActionName());

    }

    private static List<String> createTestString() {
        return Arrays.asList("abc;PREVIEW", "defiklm;THUMBNAIL");
    }
}
