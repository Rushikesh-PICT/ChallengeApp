package com.rishi.ChallengeApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ChallengeController {

private ChallengeService challengeService;
public ChallengeController(ChallengeService challengeService){
    this.challengeService = challengeService;
}

    @GetMapping("/challenges")
    public ResponseEntity<List<Challenge>> getAllChallenges(){
        return new ResponseEntity<>(challengeService.getAllChallenges(),HttpStatus.OK);
    }

    @PostMapping("/challenges")
    public ResponseEntity<String> addChallenges(@RequestBody Challenge challenge){
        boolean isadd = challengeService.addChallenges(challenge);
        if(isadd)
        return new ResponseEntity<>("Challenge add succesfully",HttpStatus.OK);
        else return new ResponseEntity<>("Challenge not added succesfully",HttpStatus.NOT_ACCEPTABLE);
    }
    @GetMapping("/challenges/{month}")
    public ResponseEntity<Challenge> getChallenge(@PathVariable String month){
        Challenge challenge = challengeService.getChallenge(month);
        if(challenge!=null){
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/challenges/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id,@RequestBody Challenge challenge){
        boolean isupdate = challengeService.updateChallenge(id,challenge);
        if(isupdate)
            return new ResponseEntity<>("Challenge updated succesfully",HttpStatus.OK);
        else return new ResponseEntity<>("Challenge not updated succesfully",HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping("/challenges/{id}")
    public ResponseEntity<String> DeleteChallenge(@PathVariable Long id){
        boolean isdelete = challengeService.deleteChallenge(id);
        if(isdelete)
            return new ResponseEntity<>("Challenge Deleted succesfully",HttpStatus.OK);
        else return new ResponseEntity<>("Challenge not Deleted",HttpStatus.NOT_FOUND);
    }

}
