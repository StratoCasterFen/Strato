package by.academy.mydao;
	
public interface DaoFactory<Context> {

	public interface DaoCreator<Context> {
		public GenericDao create(Context context);
	}

	public Context getContext() throws DaoException;

	public GenericDao getDao(Context context, Class dtoClass) throws DaoException;

}
