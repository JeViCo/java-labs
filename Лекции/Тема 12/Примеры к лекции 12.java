// *** Frame
import java.awt.*;

public class FrameExample {
	private Frame f;
	
	public FrameExample() {
		f = new Frame("Hello Out There!");
	}

	public void launchFrame() {
		f.setSize(170,170);
		f.setBackground(Color.blue);
		f.setVisible(true);
	}

	public static void main(String args[]) {
		FrameExample guiWindow = new FrameExample();
		guiWindow.launchFrame();
	}
}

// *** Panel
import java.awt.*;

public class FrameWithPanel {
	private Frame f;
	private Panel pan;

	public FrameWithPanel(String title) {
		f = new Frame(title);
		pan = new Panel();
	}

	public void launchFrame() {
		f.setSize(200,200);
		f.setBackground(Color.blue);
		f.setLayout(null); // Попробуйте закомментировать эту сроку
		pan.setSize(100,100);
		pan.setBackground(Color.yellow);
		f.add(pan);
		f.setVisible(true);
	}

public static void main(String args[]) {
	FrameWithPanel guiWindow = new FrameWithPanel("Frame with Panel");
	guiWindow.launchFrame();
	}
}

// *** FlowLayout
import java.awt.*;
public class LayoutExample {
	private Frame f;
	private Button b1;
	private Button b2;

	public LayoutExample() {
		f = new Frame("GUI example");
		b1 = new Button("Press Me");
		b2 = new Button("Don’t press Me");
	}

	public void launchFrame() {
		f.setLayout(new FlowLayout());
		f.add(b1);
		f.add(b2);
		f.pack(); // Попробуйте закомментировать эту сроку
		f.setVisible(true);
	}

	public static void main(String args[]) {
		LayoutExample guiWindow = new LayoutExample();
		guiWindow.launchFrame();
	}
}

//*** BorderLayout
import java.awt.*;
public class BorderExample {
	private Frame f;
	private Button bn, bs, bw, be, bc;
	public BorderExample() {
		f = new Frame("Border Layout");
		bn = new Button("North");
		bs = new Button("South");
		bw = new Button("West");
		be = new Button("East");
		bc = new Button("Center");
	}
	public void launchFrame() {
		f.add(bn, BorderLayout.NORTH);
		f.add(bs, BorderLayout.SOUTH);
		f.add(bw, BorderLayout.WEST);
		f.add(be, BorderLayout.EAST);
		f.add(bc, BorderLayout.CENTER);
		f.setSize(200,200); // Попробуйте заменить на f.pack();
		f.setVisible(true);
	}
	public static void main(String args[]) {
		BorderExample guiWindow2 = new BorderExample();
		guiWindow2.launchFrame();
	}
}

//*** GridLayout
import java.awt.*;
public class GridExample {
	private Frame f;
	private Button b1, b2, b3, b4, b5, b6;
	public GridExample() {
		f = new Frame("Grid Example");
		b1 = new Button("1"); b2 = new Button("2");
		b3 = new Button("3"); b4 = new Button("4");
		b5 = new Button("5"); b6 = new Button("6");
	}
	public void launchFrame() {
		f.setLayout (new GridLayout(3,2));
		f.add(b1);	f.add(b2);
		f.add(b3);	f.add(b4);
		f.add(b5);	f.add(b6);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String args[]) {
		GridExample grid = new GridExample();
		grid.launchFrame();
	}
}

//*** Вложенные панели
import java.awt.*;
public class ComplexLayoutExample {
	private Frame f;
	private Panel p;
	private Button bw, bc, bfile, bhelp;
	public ComplexLayoutExample() {
		f = new Frame("GUI ComplexLayout");
		bw = new Button("West"); bc = new Button("Work space region");
		bfile = new Button("File"); bhelp = new Button("Help");
	}
	public void launchFrame() {
		f.add(bw, BorderLayout.WEST);
		f.add(bc, BorderLayout.CENTER);
		p = new Panel();
			p.add(bfile);
			p.add(bhelp);
		f.add(p, BorderLayout.NORTH);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String args[]) {
		ComplexLayoutExample gui = new ComplexLayoutExample();
		gui.launchFrame();
	}
}

//*** Canvas
import java.awt.*;
public class TestCanvas extends Canvas {
public void paint(Graphics g) {
g.drawLine(0, 0, getWidth(), getHeight());
g.drawLine(0, getHeight(),getWidth(), 0);
}
public static void main(String arg[]) {
Frame f = new Frame("Test frame");
f.setSize(400, 300);
f.add(new TestCanvas());
f.setVisible(true);
}
}

// ***Синусоида
import java.awt.*;
      
public class SinCanvas extends Canvas {

  public void paint(Graphics g) {
    int height = getHeight(), 
        width = getWidth();
    // Вычисляем масштаб таким образом, 
	// чтобы на компоненте всегда умещалось
	// 5 периодов
    double k=2*Math.PI*5/width;
    int sy = calcY(0, width, height, k);
    for (int i=1; i<width; i++) {
      int nsy = calcY(i, width, height, k);
      g.drawLine(i-1, sy, i, nsy);
      sy=nsy;
    }
  }
  // метод, вычисляющий значение функции
  // для отображения на экране
  private int calcY(int x, int width, 
                    int height, double k) {
    double dx = (x-width/2.)*k;
    return (int)(height/2.*(1-Math.sin(dx)));
  }

  public static void main(String arg[]) {
    Frame f = new Frame("Test frame");
    f.setSize(400, 300);
    f.add(new SinCanvas());
    f.setVisible(true);
  }
}
