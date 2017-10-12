package build;

/**
 * Created by mac on 2017/10/9.
 */
public class BuilderModel {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carvohydrate;

    public static class Builder implements BuilderInterface<BuilderModel> {

        private final int servingSize;
        private final int servings;
        private  int calories=0;
        private  int fat=0;
        private  int sodium=0;
        private  int carvohydrate=0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }
        public Builder calories(int calories){
            this.calories=calories;
            return this;
        }
        public Builder fat(int fat){
            this.fat=fat;
            return this;
        }
        public Builder sodium(int sodium){
            this.sodium=sodium;
            return this;
        }
        public Builder carvohydrate(int carvohydrate){
            this.carvohydrate=carvohydrate;
            return this;
        }
        @Override
        public BuilderModel build(){
            return new BuilderModel(this);
        }



    }

    public BuilderModel(Builder builder) {
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
        this.carvohydrate = builder.carvohydrate;
    }

    public static void main(String[] args) {
        BuilderModel builderModel=new BuilderModel.Builder(240, 0).calories(12).sodium(21).carvohydrate(23).build();
        System.out.println("end");

    }
}
