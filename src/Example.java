import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.awt.GLJPanel;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;

import com.jogamp.opengl.util.FPSAnimator;


@SuppressWarnings("serial")
public class Example extends GLJPanel implements GLEventListener {
	
	private static int width;
	private static int height;
	private FPSAnimator animator;

	public Example() {
		setFocusable(true);
		addGLEventListener(this);
		animator = new FPSAnimator(this, 60, false);
		animator.start();
		width = height = 800;
	}

	@Override
	public void display(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		gl.glEnable(GL2.GL_DEPTH_TEST);
		gl.glShadeModel(GL2.GL_SMOOTH);
		gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);
		gl.glEnable(GL2.GL_CULL_FACE);
		gl.glEnable(GL2.GL_NORMALIZE);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
		gl.glEnable(GL2.GL_LIGHTING);
		gl.glLightModeli(GL2.GL_LIGHT_MODEL_LOCAL_VIEWER, GL2.GL_TRUE);
		gl.glLoadIdentity();
		GLU glu = new GLU();


		glu.gluPerspective(1, (double) getWidth() / getHeight(), 0.3, 50);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {
		GL2 gl = drawable.getGL().getGL2();

		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		GLU glu = new GLU();

		glu.gluPerspective(100, (double) getWidth() / getHeight(), 0.1, 100);
		gl.glMatrixMode(GL2.GL_MODELVIEW);

	}

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.getContentPane().add(new Example());
		window.setSize(width, height);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
