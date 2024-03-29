import de.telran.ImageProcessor;
import de.telran.entity.ActionableImage;
import de.telran.entity.ImageDescriptor;
import de.telran.service.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ImageProcessorTest {

    ImageDescriptorService imageDescriptorService = mock(ImageDescriptorService.class);
    DownloadService downloadService = mock(DownloadService.class);
    ImageService imageService = mock(ImageService.class);
    ImageFileService imageFileService = mock(ImageFileService.class);
    CsvFileService csvFileService = mock(CsvFileService.class);
    ConfigService configService = mock(ConfigService.class);


    ImageProcessor processor;

    @Before
    public void setUp() {
        processor = new ImageProcessor(imageDescriptorService, downloadService, imageService, imageFileService,
                csvFileService, configService);
    }

    @Test
    public void testDoProcessing() {
        //configure mock
        List<ImageDescriptor> testImageDescriptors = createTestImageDescriptors();
        //List<ActionableImage> downloadedImage = createDownloadedImage();
        when(imageDescriptorService.getImageDescriptors(any())).thenReturn(testImageDescriptors);
        when(downloadService.downloadImages(any())).thenReturn(createDownloadedImage());

        //execute test method
        processor.doProcessing("test.txt");

        //verify
        verify(imageDescriptorService, times(1)).getImageDescriptors("test.txt");
        verify(downloadService, times(1)).downloadImages(any());

        verify(imageFileService, times(2)).saveImageAsFile(any());

    }

    private static List<ActionableImage> createDownloadedImage() {
        return Arrays.asList(
                new ActionableImage(null, true, "http://server.com/image1.jpg", "PREVIEW"),
                new ActionableImage(null, true, "http://server.com/image2.jpg", "THUMBNAIL"));
    }

    private static List<ImageDescriptor> createTestImageDescriptors() {
        return Arrays.asList(
                new ImageDescriptor("http://server.com/image1.jpg", "PREVIEW"),
                new ImageDescriptor("http://server.com/image2.jpg", "THUMBNAIL"));
    }
}
