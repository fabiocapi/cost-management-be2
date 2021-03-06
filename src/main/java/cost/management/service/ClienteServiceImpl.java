package cost.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cost.management.entities.Cliente;
import cost.management.repository.ClienteRepository;
@Service
public class ClienteServiceImpl implements ClienteService {
	
	private String pIvaRegex="\\d{11}";

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Cliente findByPartitaIva(String partitaIva) {
		return clienteRepository.findByPartitaIva(partitaIva);
	}
	@Override
	public List<Cliente> findByPartitaIvaContaining(String partitaIva) {
		return clienteRepository.findByPartitaIvaContaining(partitaIva);
	}
	@Override
	public List<Cliente> findByPecContaining(String pec) {
		return clienteRepository.findByPecContaining(pec);
	}
	@Override
	public List<Cliente> findByRagioneSocialeContaining(String rs){
		return clienteRepository.findByRagioneSocialeContaining(rs);
	}
	@Override
	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}
	@Override
	public List<Cliente> findByCodiceFiscaleContaining(String cf) {
			return clienteRepository.findByCodiceFiscaleContaining(cf);
	
	}
	@Override
	public List<Cliente> findByCodiceInterscambioContaining(String ci) {
		return clienteRepository.findByCodiceInterscambioContaining(ci);
	}
	
	@Override
	public Cliente addCliente(Cliente cli) {
		return clienteRepository.save(cli);
	}
	
	@Override
	public Cliente updateCliente(Cliente cli,String id) {
		if(isValidId(id)) {
			cli.setPartitaIva(id);
			return clienteRepository.save(cli);
		}return null;
	}
	
	@Override
	public void deleteCliente(String id) {
		if(isValidId(id)) 
			clienteRepository.deleteById(id);
	}
	
	private boolean isValidId(String id) {
		if (id.matches(pIvaRegex))return true;
		return false;
	}
}
