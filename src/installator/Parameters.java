package installator;

import java.util.ArrayList;

/**
 * Контейнер для хранения данных полученных с конфигурации
 * @author vera
 */
public class Parameters {

    public ArrayList<Object> parametersList = new ArrayList<Object>();

    /**
     * Добавить параметр в список
     * @param obj 
     */
    public void addParameter(Object obj) {
        parametersList.add(obj);
    }

    /**
     * добавить параметр в некоторое место списка
     * @param index
     * @param obj 
     */
    public void addParameter(int index, Object obj) {
        parametersList.add(index, obj);
    }

    /**
     * Удалить элемент списка
     * @param index 
     */
    public void removeParameter(int index) {
        parametersList.remove(index);
    }

    /*
    public void addParameterChoiceStage(int id) {
        parametersList.add(id);
    }

    public void addParameterMultiChoiceStage(Integer[] m) {
        parametersList.add(m);
    }

    public void addParameterPathStage(String s) {
        parametersList.add(s);
    }*/
    
    /**
     * получить элемент списка
     * @param index
     * @return 
     */
    public Object getParameter(int index) {
        return parametersList.get(index);
    }
/*
    public Integer[] getArrayParameter(int i) {
        if (getParameter(i) instanceof Integer[]) {
            return (Integer[]) getParameter(i);
        } else {
            throw new ClassCastException(" returns " + getParameter(i).getClass() + "No Array");
        }
    }

    public String getStringParameter(int i) {
        if (getParameter(i) instanceof String) {
            return (String) getParameter(i);
        } else {
            throw new ClassCastException(" returns " + getParameter(i).getClass() + "No string");
        }
    }

    public Integer getIntParameter(int i) {
        if (getParameter(i) instanceof Integer) {
            return (Integer) getParameter(i);
        } else {
            throw new ClassCastException(" returns " + getParameter(i).getClass() + " No integer");
        }
    }*/
}