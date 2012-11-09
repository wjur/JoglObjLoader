import java.io.*;

import com.jogamp.common.nio.Buffers;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.IOException;
import java.nio.ByteBuffer;

import javax.media.opengl.*;
import javax.media.opengl.glu.*;

/**
 * Image loading class that converts BufferedImages into a data structure that
 * can be easily passed to OpenGL.
 * 
 * @author Pepijn Van Eeckhoudt Downloaded from:
 *         http://www.felixgers.de/teaching/jogl/
 */

// Uses the class GLModel from JautOGL to load and display obj files.
public class ModelLoaderOBJ {
	
	/*
	public void init(GL2 gl) {
		String path1 = "W:\\nauka\\msc\\gk\\asemalaituri\\spot.obj";
		try {

			FileInputStream r_path1 = new FileInputStream(path1);
			BufferedReader b_read1 = new BufferedReader(new InputStreamReader(
					r_path1));
			model1 = new GLModel(b_read1, true,
					"W:\\nauka\\msc\\gk\\asemalaituri\\spot.mtl", gl);
			r_path1.close();
			b_read1.close();

		} catch (Exception e) {
			System.out.println("LOADING ERROR" + e);
		}

		System.out.println("ModelLoaderOBJ init() done"); // ddd
	}

	public void draw(GL2 gl) {
		gl.glPushMatrix();
		model1.opengldraw(gl);
		gl.glPopMatrix();

	}*/
	
	public static GLModel LoadModel(String objPath, String mtlPath, GL2 gl)
	{
		GLModel model = null;
		try {
			FileInputStream r_path1 = new FileInputStream(objPath);
			BufferedReader b_read1 = new BufferedReader(new InputStreamReader(
					r_path1));
			model = new GLModel(b_read1, true,
					mtlPath, gl);
			r_path1.close();
			b_read1.close();

		} catch (Exception e) {
			System.out.println("LOADING ERROR" + e);
		}

		System.out.println("ModelLoaderOBJ init() done"); // ddd
		return model;
	}
}
