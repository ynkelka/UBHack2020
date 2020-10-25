package com.example.ubhack2020;
import java.util.ArrayList;
import java.util.List;

public class Helpers {
    //converts a single food object to a single string to be displayed
    public static String foodToRecipe(Food food){
        String result = "";
        //adding food name
        result = result + "Name : " + food.getName() + "\n";
        result = result + "description : " + food.getDescription() + "\n";
        result = result + "tags: ";
        //adding tags
        for(String tag: food.getTag()){
            result = result +tag+", ";
        }
        result = result+"\n";
        result = result + "Ingredients : \n\n";
        //adding ingredient list
        for(Ingredients ingredient : food.getIngredient()){
            result = result + "\t";
            result = result + "name : " + ingredient.getName() + "\n";

            result = result + "\t";
            result = result + "amount : " + ingredient.getAmount() + " " + ingredient.getUnit() + "\n";

      /*result = result + "\t";
      result = result + "unit : " + ingredient.getUnit() + "\n";*/

            result = result + "\t";
            result = result + "prep : " + ingredient.getPrep() + "\n\n";
        }

        //adding steps
        int counter = 1;
        for(String step : food.getStep()){
            result = result + "step " + counter + ": " + step + "\n";
            counter++;
        }

        return result;
    }

    //converts a list of food object to a single string
    public static String foodsToRec(List<Food> all){
        List<String> result = new ArrayList<>();
        String last = "";
        for(Food food : all){
            String s = foodToRecipe(food);
            result.add(s);
        }
        for(String s : result){
            last = last + s + "\n\n";
        }
        return last;
    }

    //converts a list of food objects to a list of strings
    public static List<String> foodsToRecList(List<Food> all){
        List<String> result = new ArrayList<>();
        for(Food food : all){
            String s = foodToRecipe(food);
            result.add(s);
        }
        return result;
    }

    //sorts a list of food objects based on an inputted tag
    public static List<Food> tagsToRec(List<Food> all, String input){
        List<Food> result = new ArrayList<>();
        input = input.toLowerCase();
        for(Food food : all){
            for(String tag : food.getTag()){
                if(tag.toLowerCase().equals(input)){
                    result.add(food);
                }
            }
        }
        return result;
    }

    //sorts a list of food objects based on an inputted ingredient string (must be separated by commas with no spaces) this version will consider a recipe valid if it contains any of the ingredients in the input
    public static List<Food> ingredToRec(List<Food> all, String input){
        List<Food>result = new ArrayList<>();
        List<String>ingreds = new ArrayList<>();
        String split[] = input.split(",",0);
        for(String s : split){
            ingreds.add(s.toLowerCase());
        }

        for(Food food : all){
            for(Ingredients ing : food.getIngredient()){
                if(ingreds.contains(ing.getName().toLowerCase())){
                    result.add(food);
                }
            }
        }
        return result;
    }

    //This version of ingredToRec includes a recipe if it contains every ingredient that was listed, but it can have more as well
    public static List<Food> ingredToRec2(List<Food>all, String input){
        int count = 0;
        List<Food>result = new ArrayList<>();
        List<String>ingreds = new ArrayList<>();
        String split[] = input.split(",",0);
        for(String s : split){
            count++;
            ingreds.add(s.toLowerCase());
        }

        int countInRec = 0;
        for(Food food : all){
            for(Ingredients ing : food.getIngredient()){
                if(ingreds.contains(ing.getName().toLowerCase())){
                    countInRec++;
                }
            }
            if(count == countInRec){
                result.add(food);
            }
            countInRec = 0;
        }
        return result;
    }

    //This version of ingredToRec includes a recipe if and only if the recipe contains the exact number of ingredients that were inputted, and those ingredients are the exact same ingredients that were inputted
    public static List<Food> ingredToRec3(List<Food>all, String input){
        int count = 0;
        List<Food>result = new ArrayList<>();
        List<String>ingreds = new ArrayList<>();
        String split[] = input.split(",",0);
        for(String s : split){
            count++;
            ingreds.add(s.toLowerCase());
        }

        int countInRec = 0;
        int totalInRec = 0;
        for(Food food : all){
            for(Ingredients ing : food.getIngredient()){
                if(ingreds.contains(ing.getName().toLowerCase())){
                    countInRec++;
                }
                totalInRec++;
            }
            if(count == countInRec && count == totalInRec){
                result.add(food);
            }
            countInRec = 0;
            totalInRec = 0;
        }
        return result;
    }
}
