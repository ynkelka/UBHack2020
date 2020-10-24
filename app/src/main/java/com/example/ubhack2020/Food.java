package com.example.ubhack2020;


public class Food {

    //These need to be the same as fields in DB
    private String name;
    private String description;
    private String [] tag;
    private Ingredients [] ingredient;
    private String [] step;

    public Food() {
    }


    public Food(String name, String description, String[] tag, Ingredients[] ingredient, String[] step) {
        this.name = name;
        this.description = description;
        this.tag = tag;
        this.ingredient = ingredient;
        this.step = step;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getTag() {
        return this.tag;
    }

    public void setTag(String[] tag) {
        this.tag = tag;
    }

    public Ingredients[] getIngredient() {
        return this.ingredient;
    }

    public void setIngredient(Ingredients[] ingredient) {
        this.ingredient = ingredient;
    }

    public String[] getStep() {
        return this.step;
    }

    public void setStep(String[] step) {
        this.step = step;
    }

    public Food name(String name) {
        this.name = name;
        return this;
    }

    public Food description(String description) {
        this.description = description;
        return this;
    }

    public Food tag(String[] tag) {
        this.tag = tag;
        return this;
    }

    public Food ingredient(Ingredients[] ingredient) {
        this.ingredient = ingredient;
        return this;
    }

    public Food step(String[] step) {
        this.step = step;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Food)) {
            return false;
        }
        Food food = (Food) o;
        return Objects.equals(name, food.name) && Objects.equals(description, food.description) && Objects.equals(tag, food.tag) && Objects.equals(ingredient, food.ingredient) && Objects.equals(step, food.step);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, tag, ingredient, step);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", tag='" + getTag() + "'" +
            ", ingredient='" + getIngredient() + "'" +
            ", step='" + getStep() + "'" +
            "}";
    }
    
    

}
