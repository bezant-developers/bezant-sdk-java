# Bezant Baas Java SDK

The Bezant Baas SDK is a sdk for building decentralized applications over the Bezant blockchain.

> Note: While the Bezant Baas is now testnet, it is still under active development; there may be breaking changes.

&nbsp;

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
BezantApi api = BezantApiFactory.createTestNetApi("{API KEY}");
```

for Main Net
```java
BezantApi api = BezantApiFactory.createMainNetApi("{API KEY}");
```

#### List of Api Functions
- createWallet(String: walletSecretKey)
- transferToken(TokenTransferRequest: request)
- getTokenBalance(String: tokenName, String: address)
- invokeChaincode(ChaincodeInvokeRequest: request)
- queryChaincode(ChaincodeQueryRequest: request)


## License
MIT