package CrazyBird;

class Bird extends Thread {
	Column co = new Column();
	Column cc;
	public double y, v, a = 0.2;
	public int dead = 0;
	Thread th;
	CrazyBird fb;

	public Bird(double y, double v, CrazyBird fb) {
		super();
		this.y = y;
		this.v = v;
		this.fb = fb;
	}

	public Bird() {
		super();
	}

	@SuppressWarnings("deprecation")
	public void run() {
		while (y + 30 < fb.h - 115) {
			v += a;
			y += v;
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			if (dead == 1) {
				while (y + 30 < fb.h - 115) {
					v += a;
					y += v;
					try {
						Thread.sleep(7);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			if (dead == 2 || dead == 3) {
				th.stop();
			}
		}
		if (y + 30 >= fb.h - 115) {
			dead = 1;
		}
	}
}