package com.example.ubhack2020;

public class Ingredients {

    private int Amount;
    private String unit;
    private String name;
    private String Prep;

    public Ingredients() {
    }

    public Ingredients(int Amount, String unit, String name, String Prep) {
        this.Amount = Amount;
        this.unit = unit;
        this.name = name;
        this.Prep = Prep;
    }

    public int getAmount() {
        return this.Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public String getUnit() {
        return this.unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrep() {
        return this.Prep;
    }

    public void setPrep(String Prep) {
        this.Prep = Prep;
    }

    public Ingredients Amount(int Amount) {
        this.Amount = Amount;
        return this;
    }

    public Ingredients unit(String unit) {
        this.unit = unit;
        return this;
    }

    public Ingredients name(String name) {
        this.name = name;
        return this;
    }

    public Ingredients Prep(String Prep) {
        this.Prep = Prep;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Ingredients)) {
            return false;
        }
        Ingredients ingredients = (Ingredients) o;
        return Amount == ingredients.Amount && Objects.equals(unit, ingredients.unit) && Objects.equals(name, ingredients.name) && Objects.equals(Prep, ingredients.Prep);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Amount, unit, name, Prep);
    }

    @Override
    public String toString() {
        return "{" +
            " Amount='" + getAmount() + "'" +
            ", unit='" + getUnit() + "'" +
            ", name='" + getName() + "'" +
            ", Prep='" + getPrep() + "'" +
            "}";
    }

}