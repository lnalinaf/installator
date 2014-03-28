package installator;

import java.util.ArrayList;

/**
 *
 * @author vera
 */
public class Parameters {

    public ArrayList<Object> parametersList;

    public void addParameter(Object obj) {
        parametersList.add(obj);
    }

    public void addParameter(int index, Object obj) {
        parametersList.add(index, obj);
    }

    public void removeParameter(Object obj) {
        parametersList.remove(obj);
    }

    public void removeParameter(int index) {
        parametersList.remove(index);
    }

    public void addParameterChoiceStage(int id) {
        parametersList.add(id);
    }

    public void addParameterMultiChoiceStage(Integer[] m) {
        parametersList.add(m);
    }

    public void addParameterPathStage(String s) {
        parametersList.add(s);
    }

    public Object getParameter(int i) {
        return parametersList.get(i);
    }

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
    }
}