import java.awt.image.BufferedImage;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	private BufferedImage imagebuffer;
	
	private static final ImageLoader imageloader = new ImageLoader();
	
	private ImageLoader(){}
	
	public static ImageLoader getInstance(){
		return imageloader;
	}
	
	public BufferedImage loadImage(String path) throws IOException{
		return imagebuffer = ImageIO.read(ImageLoader.class.getResource(path));
		
	};
	
	public BufferedImage getImageBuffer(){
		BufferedImage img = imagebuffer;
		imagebuffer = null;
		return img;
	}
}
