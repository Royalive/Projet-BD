package edu.iut.input;

/**
 * Classe représentant un modèle de donnée.
 *
 * Un modèle de donnée est caractérisé par un type E,
 * transcrit à l'aide d'un convertisseur ainsi que
 * d'un label affiché à l'uilisateur.
 * @param <E>
 */
public class InputData<E> {
    private InputConverter<E> converter;
    private String inputLabel;

    public InputData(String label, InputConverter<E> converter){
        this.converter = converter;
        this.inputLabel = label;
    }

    public String getInputLabel(){
        return inputLabel;
    }

    public InputConverter<E> getConverter(){
        return converter;
    }
}
