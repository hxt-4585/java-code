import com.powernode.bank.dao.AccountDao;
import com.powernode.bank.dao.impl.AccountDaoImpl;
import com.powernode.bank.pojo.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class WebTest {

    @Test
    public void AccountDaoTest(){
        String fromActno = "act001";
        String toActno = "act002";
        AccountDao accountDao = new AccountDaoImpl();
        Account fromAct = accountDao.selectByActno(fromActno);
        System.out.println(fromAct);



    }
}
