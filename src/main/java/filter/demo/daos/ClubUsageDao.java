package filter.demo.daos;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.Transaction;

import filter.demo.db.HibernateUtil;
import filter.demo.models.ClubUsage;

public class ClubUsageDao {
	Session session = HibernateUtil.getSession();
	
	public List<ClubUsage> list(){
		Transaction transaction = null;
		try {
			
			transaction	= session.beginTransaction();
			List<ClubUsage> results = session.createQuery("FROM ClubUsage").list();
			transaction.commit();
			return results;
			
		}catch(Exception ex) {
			if(transaction!=null) {
				transaction.rollback();
			}
			ex.printStackTrace();
		}
		return null;
	}
}
