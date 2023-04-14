package asyx.sharing.simplebackend.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestBankAdd {
	
	private String bankName;
	private String bankCode;

}
