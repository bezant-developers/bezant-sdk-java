# Bezant BaaS Java SDK

The Bezant BaaS SDK is a sdk for building decentralized applications over the Bezant blockchain.

## Table of contents

* [Detailed api documentation](https://docs.google.com/document/d/1Eh6hWbgVatFP83iFv_SJIE411rHai0U0F7M0uv4KN3A/edit?usp=sharing)

&nbsp;

### Prerequisites

* Java 1.7 +
* Maven 3.x +

### Installation 
Step 1. Add the JitPack repository to your build file
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
Step 2. Add the dependency
```xml
<dependency>
    <groupId>com.github.bezant-developers</groupId>
    <artifactId>bezant-sdk-java</artifactId>
    <version>0.1</version>
</dependency>
```

### SDK Usage
for Test Net
```java
BezantWalletApi walletApi = BezantWalletApi.testNet("{API_KEY}");
BezantChaincodeApi chaincodeApi = BezantChaincodeApi.testNet("{API_KEY}");
BezantBrc20Api brc20Api = BezantBrc20Api.testNet("{API_KEY}");
```

for Main Net
```java
BezantWalletApi walletApi = BezantWalletApi.mainNet("{API_KEY}");
BezantChaincodeApi chaincodeApi = BezantChaincodeApi.mainNet("{API_KEY}");
BezantBrc20Api brc20Api = BezantBrc20Api.mainNet("{API_KEY}");
```

#### List of Api Functions
- Wallet API
    - createWallet
    - changeWalletPassword
  
- Chaincode API
    - invokeChaincode
    - queryChaincode
    
- BRC20 API
    - tokenTransfer
    - tokenAllowance
    - tokenApprove
    - tokenTransferFrom
    - tokenTotalSupply
    - tokenBalance

## License
MIT