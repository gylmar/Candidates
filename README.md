College Applicant Classifier (Java) - Work in Progress
---

**Description**: A local college here in California wants to save money by
partially automating its applicant review process. In short:
* Some applicants can be accepted without further review by admissions staff (“instant accept”).
* Other applicants can be safely rejected without further review by admissions staff (“instant reject”).
* The remaining applicants need “further review” by admissions staff, because they’re not an “instant accept” nor an “instant reject.”

There are several criteria that the college requires to be implemented in this applicant classifier:
* To qualify as **instant accept**, all of the following criteria must be met.
    * In-state (California) age 17 or older, and younger than 26; or older than 80 from any
state.
    * High School GPA of 90% or higher of scale provided in their application. For example,
3.6 on a 4.0 scale; or 4.5 on a 5.0 scale.
    * SAT score greater than 1920 or ACT score greater than 27. Note: Both, or only one of
these, may be present in the applicant.
    * No “instant reject” criteria is hit (see below).
* All applicants can be subject to **instant reject**, if they meet any of the following criteria. Some of
the criteria is dubious, admittedly, but the Dean insisted on it.
    * 1 or more felonies over the past 5 years.
    * High School GPA below 70% of scale provided on application. For example, 2.8 on a 4.0
scale.
    * The applicant claimed to be a negative age (it happens!) e.g. “-20” years old.
    * The applicant’s first and/or last name are not in the form of first letter capitalized, the
rest lower case.
* If the candidate does not qualify for instant accept nor qualifies for instant reject, then they should be flagged for **further review** instead.

What the college needs you to produce for them (artifacts):
* Code to store the candidate application information needed (no need to store in database, etc.- just code to store the information in variables in memory). Please write this in Java.
* Develop code to evaluate that application, and return the result to convey “instant accept”, “instant reject”, or “further review”. Additionally, it should return plain text descriptions for each reason that the applicant was rejected if the user was marked “instant reject.”
* Make the code so that it can handle potential changes and additions to the rules in the future with ease.

Simplifying assumptions:
* All applicants are from the United States, from one of the 50 states.
* Another team will use the code you made to populate the applicant data and get the
accept/reject/review result from it. You don’t have to worry about where the applicant data is
coming from- that’s their job. That said- you can and should plug in dummy data into the
application code to test it (with junit tests, perhaps). Provide these tests as well if you create
any.
