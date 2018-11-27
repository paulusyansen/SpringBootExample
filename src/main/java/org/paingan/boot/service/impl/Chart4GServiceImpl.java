package org.paingan.boot.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.paingan.boot.domain.Chart4G;
import org.paingan.boot.dto.ChartDTO;
import org.paingan.boot.repository.Chart4GRepository;
import org.paingan.boot.repository.spec.BaseSpecificationBuilder;
import org.paingan.boot.service.Chart4GService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class Chart4GServiceImpl implements Chart4GService {
	
	@Value("${kafka.topic}")
	private String topic = "qz8x4wx7-paingan";
	
	
	@Autowired
	private Chart4GRepository chart4GRepository;
	
	/*
	 * (non-Javadoc)
	 * @see org.paingan.boot.service.Chart4GService#findAllChart4G()
	 */
	public List<ChartDTO> findAllChart4G() {
		return chart4GRepository.findAllChart4G();
	}

	/*
	 * (non-Javadoc)
	 * @see org.paingan.boot.service.Chart4GService#findAll()
	 */
	public List<Chart4G> findAll() {
		return chart4GRepository.findAll();
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.paingan.boot.service.Chart4GService#save(org.paingan.boot.domain.Chart4G)
	 */
	public Chart4G save(Chart4G chart4G) {
		return chart4GRepository.save(chart4G);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.paingan.boot.service.Chart4GService#search(java.lang.String)
	 */
	public List<Chart4G> search(String search) {
		BaseSpecificationBuilder<Chart4G> builder = new BaseSpecificationBuilder<Chart4G>();
		
		Pattern pattern = Pattern.compile("(\\w+?)(:|<|>|<:|>:)(\\w+?),", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(search + ",");
        
        while (matcher.find()) {
        	//SearchOperation sOpr = SearchOperation.getSimpleOperation(matcher.group(2).charAt(0));
            builder.with(matcher.group(1), matcher.group(2) , matcher.group(3), null, null);
        }
         
        Specification<Chart4G> spec = builder.build();
        
        return chart4GRepository.findAll(spec);
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.paingan.boot.service.Chart4GService#findChart4GById(long)
	 */
	public Optional<Chart4G> findChart4GById(long id) {
		Optional<Chart4G> chart4G = chart4GRepository.findById(id);
		
		if(!chart4G.isPresent()) {
			throw new UsernameNotFoundException("id-"+id);
		}
		
		return chart4G;
	}
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	 
	public void sendMessage(String msg) {
	   this.kafkaTemplate.send(topic, msg);
	   System.out.println("Sent sample message [" + msg + "] to " + topic);
	} 
	
	@KafkaListener(topics = "${kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
	public void processMessage(String message) {
	   System.out.println("Received message "+message+" in group - group-id: " + "${spring.kafka.consumer.group-id}");
	}
}
