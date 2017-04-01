package app.controller;
import app.model.*;
import app.service.DaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountControler {

	@Autowired
	private DaoService daoService;
	
	@RequestMapping(value="/home")
	public String home(){
		return "homepage";
	}
	
	@RequestMapping("/accounts")
	public String Account(Model model, String accountcode, @RequestParam(name="page", defaultValue="0") int page, @RequestParam(name="size", defaultValue="10") int size){
		model.addAttribute("accountcode", accountcode);
		try{
			Account acc = daoService.checkAccount(accountcode);
			Page<Transaction> pageTransactions = daoService.TransactionsList(accountcode, page, size);
			model.addAttribute("transactionsList", pageTransactions.getContent());
			int [] pages = new int [pageTransactions.getTotalPages()];
			model.addAttribute("pages", pages);
			model.addAttribute("account", acc);
		}catch(Exception e){
			model.addAttribute("accountException", e);
		}

		return "homepage";
	}

	@RequestMapping(value="/transactions", method=RequestMethod.POST)
	public String Transactions(Model model, String operationType, String accountcode, double amount, String accountcode2){
		try{
			if(operationType.equals("deposit")){
				daoService.makeDeposit(accountcode, amount);
		}

		else if(operationType.equals("withdraw")){
			daoService.makeWithdraw(accountcode, amount);
		}

		else if(operationType.equals("transfer")){
			daoService.Transfer(accountcode, accountcode2, amount);
		}
		}catch(Exception e){
			model.addAttribute("operationException", e);
			return "redirect:/accounts?accountcode="+accountcode+"&operationException="+e.getMessage();
		}

		return "redirect:/accounts?accountcode="+accountcode;
	}

}

