package edu.cw.cbr.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.cw.cbr.model.dao.ConnectedDAO;
import edu.cw.cbr.model.domain.Task;

/**
 * The class {@code TaskUtil} contains methods for performing basic
 * operations with {@code Task}.
 * @author Dmitriy Gaydashenko
 *
 */
public class TaskUtil extends ConnectedUtil<Task>{
	
	public TaskUtil() {
		super(Task.class);
	}
	
	/**
	 * Tries to add new instance of {@code Task} to the database.
	 * If instance is invalid returns <tt>false</tt>.
	 * @param complex - computational complexity of application. 
	 * @param memoryNeed - memory requirements.
	 * @param dataToDown - amount of downloading data.
	 * @param dataToUp - amount of uploading data.
	 * @param timeReq - running time requirements.
	 * @return <tt>True</tt> if task was successfully added.
	 */
	public boolean addNewTask(float complex, float memoryNeed,
			float dataToDown, float dataToUp, float timeReq) {
		Task task = null;
		try {
			task = new Task(complex, memoryNeed, dataToDown, 
				dataToUp, timeReq);
		} catch (IllegalArgumentException ex) {
			return false;
		}
		return addNew(task);
	}
	
	/**
	 * Tries to delete dependent instances and update instance of {@code Task}.
	 *  If succeeded returns <tt>true</tt>.
	 * @param taskId - identifier of {@code Task} instance.
	 * @param complex - computational complexity of application. 
	 * @param memoryNeed - memory requirements.
	 * @param dataToDown - amount of downloading data.
	 * @param dataToUp - amount of uploading data.
	 * @param timeReq - running time requirements.
	 * @return <tt>true</tt> if deletion of dependent instances and update of
	 * instance of {@code Task}, with identifier equals to {@code taskId},
	 * succeeded. 
	 */
	public boolean updateTask(int taskId, float complex, 
			float memoryNeed, float dataToDown, float dataToUp, float timeReq) {
		Task task = null;
		try {
			task = new Task(complex, memoryNeed, dataToDown, 
				dataToUp, timeReq);	
		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
			return false;
		}
		task.setTaskId(taskId);
		return this.update(task);
	}

	@Override
	public List<String> getAllCols() {
		List<String> columnsName = new ArrayList<String>();
		columnsName.add("taskId");
		columnsName.add("computationalComplexity");
		columnsName.add("amountOfMemory");
		columnsName.add("downloadingAmountOfData");
		columnsName.add("uploadingAmountOfData");
		columnsName.add("maxRunningTime");
		return columnsName;
	}

	@Override
	protected TaskDAO getNewDAO() {
		return new TaskDAO();
	}
}

class TaskDAO extends ConnectedDAO<Task>{
	/**
	 * Represents data structure which store names of stored functions.
	 * @author Dmitriy Gaydashenko.
	 *
	 */
	private enum StoredFunction implements IStoredFunction{
		/**
		 * Name of stored function, which counts number of dependent instances of
		 * {@code Precedent} from instance of {@code Task} with identifier equals
		 * to passed parameter. 
		 */TASK_DEP_PREC_NUM_F ("SELECT task_dep_prec_num(%d)", "Precedents");
		
		private String func;
		private String IRName;
		
		StoredFunction(String func) {
			this.func = func;
		}
		
		StoredFunction(String func, String IRName) {
			this.func = func;
			this.IRName = IRName;
		}
		
		/**
		 * Return array of count functions names.
		 * @return array of count functions names.
		 */
		public static StoredFunction[] getCountFunctions() {
			return new StoredFunction[]{TASK_DEP_PREC_NUM_F};
		}
		
		@Override
		public String getFunction() {
			return this.func;
		}

		@Override
		public String getIRName() {
			return this.IRName;
		}
		
	}
	
	public TaskDAO() {
		super(Task.class);
	}
	
	@Override
	public Map<String, Integer> getDependentEntitiesNum(int taskId) {
		return getDependentEntitiesNum(taskId,
				StoredFunction.getCountFunctions());
	}
}
