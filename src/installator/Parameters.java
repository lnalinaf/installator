package installator;

import java.util.ArrayList;

/**
 * Контейнер для хранения данных полученных с конфигурации
 *
 * @author vera
 */
public class Parameters {

	public ArrayList<Object> parametersList = new ArrayList<>();

	/**
	 * Добавить параметр в список
	 *
	 * @param obj fd
	 */
	public void addParameter(Object obj) {
		parametersList.add(obj);
	}

	/**
	 * добавить параметр в некоторое место списка
	 *
	 * @param index d
	 * @param obj d
	 */
	public void addParameter(int index, Object obj) {
		parametersList.add(index, obj);
	}

	/**
	 * Удалить элемент списка
	 *
	 * @param index d
	 */
	public void removeParameter(int index) {
		parametersList.remove(index);
	}

	/**
	 * получить элемент списка
	 *
	 * @param index d
	 * @return  dsf
	 */
	public Object getParameter(int index) {
		return parametersList.get(index);
	}

}