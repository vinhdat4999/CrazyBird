package CrazyBird;

class Column extends Thread {
	double x, d, v;
	public static int dem = 0;
	CrazyBird fb;
	Bird b;
	Thread th;

	public int getScore() {
		return dem;
	}

	public Column(double x, double d, double v, CrazyBird fb) {
		super();
		this.x = x;
		this.d = d;
		this.v = v;
		this.fb = fb;
	}

	public Column() {
		super();
	}

	@SuppressWarnings("deprecation")
	public void run() {
		b = new Bird();
		while (x > -100) {
			b = new Bird();
			while (x > -100) {
				x = x - v;
				if ((x == 430 && (d + 138 >= fb.b.y || (d + 288 <= fb.b.y + 30)))
						|| (d + 138 >= fb.b.y && (x < 430 && x + 70 > 400))
						|| ((fb.b.y + 30 >= 288 + d) && (x <= 430 && x + 70 >= 400))) {
					fb.b.dead = 1;
					if (((fb.b.y + 30 >= 288 + d) && (x < 430 && x + 70 >= 400))) {
						fb.b.dead = 2;
					}
					if((d + 138 >= fb.b.y && (x < 430 && x + 70 > 400))) {
						fb.b.dead=3;
					}
				}
				if (fb.b.dead == 1 || fb.b.dead == 2 || fb.b.dead==3) {
					th.stop();
				}
				if (x == 310) {
					dem++;
				}
				try {
					Thread.sleep(4);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}