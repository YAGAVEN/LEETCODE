class Robot {
private final int width;
   private final int height;
   private final int perimeter;
   private int stepsOnPerimeter;
   private boolean hasMoved;

   public Robot(int var1, int var2) {
      this.width = var1;
      this.height = var2;
      this.perimeter = 2 * (var1 + var2) - 4;
      this.stepsOnPerimeter = 0;
      this.hasMoved = false;
   }

   public void step(int var1) {
      this.stepsOnPerimeter = (this.stepsOnPerimeter + var1) % this.perimeter;
      this.hasMoved = true;
   }

   public int[] getPos() {
      int var1 = this.stepsOnPerimeter;
      if (var1 == 0) {
         return new int[]{0, 0};
      } else if (var1 <= this.width - 1) {
         return new int[]{var1, 0};
      } else if (var1 <= this.width + this.height - 2) {
         return new int[]{this.width - 1, var1 - (this.width - 1)};
      } else {
         return var1 <= 2 * this.width + this.height - 3 ? new int[]{this.width - 1 - (var1 - (this.width + this.height - 2)), this.height - 1} : new int[]{0, this.height - 1 - (var1 - (2 * this.width + this.height - 3))};
      }
   }

   public String getDir() {
      int var1 = this.stepsOnPerimeter;
      if (var1 == 0) {
         return this.hasMoved ? "South" : "East";
      } else if (var1 <= this.width - 1) {
         return "East";
      } else if (var1 <= this.width + this.height - 2) {
         return "North";
      } else {
         return var1 <= 2 * this.width + this.height - 3 ? "West" : "South";
      }
   }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */