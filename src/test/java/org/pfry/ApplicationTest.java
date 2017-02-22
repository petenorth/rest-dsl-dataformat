/*
 * Copyright 2005-2016 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version
 * 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */
package org.pfry;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    public void donutTest() throws JsonProcessingException {
    	Donut donut = new Donut();
    	donut.setDoughMix("vanilla");
    	
    	ResponseEntity<String> responseEntity = restTemplate.postForEntity("/food/donut-limits", donut, String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);	
    }
    
    @Test
    public void pastryTest() throws JsonProcessingException {
    	Pastry pastry = new Pastry();
    	pastry.setPastryType("flaky");
    	
    	ResponseEntity<String> responseEntity = restTemplate.postForEntity("/food/pastry-details", pastry, String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);	
    }

}